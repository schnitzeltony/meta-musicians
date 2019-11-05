SUMMARY = "Element Audio Plugin Host"
HOMEPAGE = "https://kushview.net/element/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit waf pkgconfig distro_features_check

REQUIRED_DISTRO_FEATURE = "x11"

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
"

SRC_URI = "gitsm://github.com/kushview/Element.git"
SRCREV = "be5fd408301278a6c6c9d26fc21b3ebc4a599ca8"
PV = "0.41.0"
S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --libdir=${libdir} \
"

FILES_${PN} += "${datadir}/element"

# TBD - we should send a fix upstream..
FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/libelement-0.so"
