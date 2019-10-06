SUMMARY = "A virtual-analog string ensemble synthesize"
HOMEPAGE = "https://github.com/jpcima/string-machine"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"

DEPENDS += " \
    virtual/libx11 \
    virtual/libgl \
    boost \
    cairo \
"

inherit pkgconfig distro_features_check qemu-ext pack_audio_plugins

REQUIRED_DISTRO_FEATURE = "x11"

SRC_URI = " \
    gitsm://github.com/jpcima/string-machine.git \
"
SRCREV = "5e8ad47d03adafa3f7ec5746025482b50d93c4ca"
S = "${WORKDIR}/git"
PV = "0.1.1+git${SRCPV}"

do_compile() {
    rm -f ${WORKDIR}/lv2_ttl_generator-data
    # manipulate scripts to keep lv2_ttl_generator-calls in script for qemu
    sed -i 's|"$GEN" "./$FILE"|echo `pwd`/$FILE >> ${WORKDIR}/lv2_ttl_generator-data|g' ${S}/dpf/utils/generate-ttl.sh

    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
    oe_runmake

    # build ttl-files must be done in quemu
    for sofile in `cat ${WORKDIR}/lv2_ttl_generator-data`; do
        cd `dirname ${sofile}`
        echo "QEMU lv2_ttl_generator for ${sofile}..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '${S}/dpf/utils/lv2_ttl_generator')} ${sofile} || echo "ERROR: for QEMU lv2_ttl_generator for ${sofile}!"
    done
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}
