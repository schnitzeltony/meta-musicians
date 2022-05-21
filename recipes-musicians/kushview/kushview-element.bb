SUMMARY = "Element Audio Plugin Host"
HOMEPAGE = "https://kushview.net/element/"
LICENSE = "GPL-3.0-only"
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
    gitsm://github.com/kushview/Element.git;branch=master;protocol=https \
    file://0001-Fix-build-with-gcc11.patch \
"
SRCREV = "532a3614bc0536e3f26ddf9bcd0f5eb581460223"
PV = "0.46.5"
S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --libdir=${libdir} \
"

PATH:append = ":${B}"

do_configure:prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

FILES:${PN} += "${datadir}/element"

# TBD - we should send a fix upstream..
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/libelement-0.so"
