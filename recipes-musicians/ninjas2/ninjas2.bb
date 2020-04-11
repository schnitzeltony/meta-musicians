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

inherit pkgconfig lv2-turtle-helper features_check pack_audio_plugins

SRC_URI = "gitsm://github.com/rghvdberg/ninjas2.git"
SRCREV = "a767a9eea4e543061993290168a321d10c08b03c"
S = "${WORKDIR}/git"
PV = "0.2.0"

REQUIRED_DISTRO_FEATURE = "x11 opengl"

EXTRA_OEMAKE += " \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

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
