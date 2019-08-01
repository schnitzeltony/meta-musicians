SUMMARY = "Rewrite of Ninjas sample slicer"
HOMEPAGE = "https://github.com/rghvdberg/ninjas2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97a733ff40c50b4bfc74471e1f6ca88b"

DEPENDS = " \
    virtual/libx11 \
    virtual/libgl \
    libsndfile1 \
    libsamplerate0 \
    jack \
"

inherit pkgconfig qemu-ext distro_features_check pack_audio_plugins

SRC_URI = "gitsm://github.com/rghvdberg/ninjas2.git"
SRCREV = "12aa2f9d150caaf602c2f1a31cb6dd078abddde2"
S = "${WORKDIR}/git"
PV = "0.1"

REQUIRED_DISTRO_FEATURE = "x11 opengl"

do_configure_prepend() {
    # reconfigure?
    if [ ! -f ${WORKDIR}/lv2-ttl-generator-data ] ; then
        # We cannot run lv2-ttl-generator in cross environment so
        # manipulate generate-ttl.sh to save lib info in ${WORKDIR}/lv2-ttl-generator-data
        sed -i 's|"$GEN" "./$FILE"|echo "`realpath  "./$FILE"`" >> ${WORKDIR}/lv2-ttl-generator-data|g' ${S}/dpf/utils/generate-ttl.sh
     else
        rm -f ${WORKDIR}/lv2-ttl-generator-data
     fi
}

EXTRA_OEMAKE += " \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_compile_append() {
    # build ttl-files must be done in quemu
    for sofile in `cat ${WORKDIR}/lv2-ttl-generator-data`; do
        cd `dirname ${sofile}`
        echo "QEMU lv2-ttl-generator for ${sofile}..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '${S}/dpf/utils/lv2_ttl_generator')} ${sofile} || echo "ERROR: for QEMU lv2-ttl-generator for ${sofile}!"
    done
}

do_install() {
    install -d ${D}${libdir}/lv2
    for plugindir in `find ${S}/bin/ -maxdepth 1 -name *.lv2`; do
        lv2dir=${D}${libdir}/lv2/`basename $plugindir`
        install -d $lv2dir
        for plugin in `find $plugindir -type f`; do
            install -m 644 $plugin $lv2dir/
        done
    done

    install -d ${D}${libdir}/vst
    for plugin in `find ${S}/bin/ -name *vst.so`; do
        install -m 644 $plugin ${D}${libdir}/vst/
    done

    install -d ${D}${bindir}
    install -m 755 ${S}/bin/ninjas2 ${D}${bindir}
}

PACKAGES =+ "${PN}-standalone"
FILES_${PN}-standalone = "${bindir}"
