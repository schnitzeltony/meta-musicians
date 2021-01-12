SUMMARY = "Element Audio Plugin Host"
HOMEPAGE = "https://kushview.net/element/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit waf gtk-icon-cache pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    boost \
    curl \
    freetype \
    libxinerama \
    alsa-lib \
    lv2 \
    lilv \
    suil \
    ladspa-sdk \
    jack \
"

SRC_URI = " \
    gitsm://github.com/kushview/Element.git \
    file://0001-Work-around-broken-git-version-creation.patch \
"
SRCREV = "d3f2ee98217f83e3b600a4163b3f8fd403f392fa"
PV = "0.45.1"
S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --libdir=${libdir} \
"

PATH_append = ":${B}"

do_configure_prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

FILES_${PN} += "${datadir}/element"

# TBD - we should send a fix upstream..
FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libelement-0.so"
