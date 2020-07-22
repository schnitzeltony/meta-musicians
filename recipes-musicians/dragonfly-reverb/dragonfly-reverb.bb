SUMMARY = "A set of free reverb effects"
HOMEPAGE = "https://github.com/michaelwillis/dragonfly-reverb"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

inherit lv2-turtle-helper pack_audio_plugins features_check

DEPENDS += " \
    virtual/libx11 \
    virtual/libgl \
    jack \
"

SRC_URI = "gitsm://github.com/michaelwillis/dragonfly-reverb.git"
SRCREV = "bf4b55d5f96ff316109335d957a32bd05e0dc289"
S = "${WORKDIR}/git"
PV = "3.2.0"

EXTRA_OEMAKE += " \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_install() {
    install -d ${D}${bindir}
    for executable in `find ${S}/bin/ -executable -mindepth 1 -maxdepth 1 -type f ! -name '*.so'`; do
        install -m 755 $executable ${D}${bindir}
    done

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
}

