SUMMARY = "Collection of DPF-based plugins"
LICENSE = "ISC & GPLv2 & GPLv3 & LGPLv3 & MIT"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=ec024abddfab2ee463c8c1ad98883d12 \
"

SRC_URI = "git://github.com/DISTRHO/DPF-Plugins.git"
SRCREV = "0530b4309bf5f451c3ee00503acc9c997d30353c"
S = "${WORKDIR}/git"
PV = "v1.3"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

inherit pkgconfig lv2-turtle-helper pack_audio_plugins features_check

# TODO standalone: *.desktop
DEPENDS += " \
    virtual/libgl \
    cairo \
    ladspa-sdk \
    lv2 \
    liblo \
    jack \
    projectm \
"

EXTRA_OEMAKE += " \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_install() {
    install -d ${D}${bindir}
    for executable in `find ${S}/bin/ -executable -mindepth 1 -maxdepth 1 -type f ! -name '*.so'`; do
        install -m 755 $executable ${D}${bindir}
    done

    install -d ${D}${libdir}/ladspa
    for plugin in `find ${S}/bin/ -name *ladspa.so`; do
        install -m 644 $plugin ${D}${libdir}/ladspa/
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

PACKAGES =+ "${PN}-standalone"
FILES_${PN}-standalone = "${bindir}"
