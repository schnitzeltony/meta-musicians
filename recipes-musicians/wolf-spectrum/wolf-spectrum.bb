SUMMARY = "Wolf Spectrum is a free spectrogram plugin"
HOMEPAGE = "https://github.com/pdesaulniers/wolf-spectrum"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fe869ee987a340198fb0d54c55c47f1"

DEPENDS = " \
    jack \
    lv2 \
"

inherit pkgconfig qemu-ext pack_audio_plugins

SRC_URI = "gitsm://github.com/pdesaulniers/wolf-spectrum.git"
SRCREV = "87d7aca59e295141a1e8019788267d3ef6d6cae7"
S = "${WORKDIR}/git"
PV = "1.0.0"

export PREFIX="${prefix}"

do_compile() {
    rm -f ${WORKDIR}/lv2_ttl_generator-data
    # manipulate scripts to keep lv2_ttl_generator-calls in script for qemu
    sed -i 's|"$GEN" "./$FILE"|echo `pwd`/$FILE >> ${WORKDIR}/lv2_ttl_generator-data|g' ${S}/dpf/utils/generate-ttl.sh

    NOOPT=true \
    SKIP_STRIPPING=true \
    BUILD_VST2=true \
    BUILD_LV2=true \
    BUILD_JACK=true \
    oe_runmake

    # build ttl-files must be done in quemu
    for sofile in `cat ${WORKDIR}/lv2_ttl_generator-data`; do
        cd `dirname ${sofile}`
        echo "QEMU lv2_ttl_generator for ${sofile}..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '${S}/dpf/utils/lv2_ttl_generator')} ${sofile} || echo "ERROR: for QEMU lv2_ttl_generator for ${sofile}!"
    done
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
