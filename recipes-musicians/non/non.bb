SUMMARY = "Lightweight and modular DAW"
HOMEPAGE = "http://non.tuxfamily.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += " \
    ntk-native \
    ladspa-sdk \
    ntk \
    jack \
    liblo \
    libsndfile1 \
    lrdf \
    libsigc++-2.0 \
"

inherit waf pkgconfig distro_features_check gtk-icon-cache

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://git.tuxfamily.org/gitroot/non/non.git"
SRCREV = "c15bfa85fdd74c1720be84277424e0f11403c81d"
S = "${WORKDIR}/git"
PV = "1.2.0+git${SRCPV}"

NON_SIMD ?= "--disable-sse"

EXTRA_OECONF = " \
    ${NON_SIMD} \
"

FILES_${PN} += "${datadir}/non-sequencer"
