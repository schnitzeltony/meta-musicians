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

inherit waf pkgconfig features_check gtk-icon-cache

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://git.tuxfamily.org/gitroot/non/non.git"
SRCREV = "d958df0486c7397c243f5ac36bf4acbc461a1e50"
S = "${WORKDIR}/git"
PV = "1.2.0+git${SRCPV}"

NON_SIMD ?= "--disable-sse"

EXTRA_OECONF = " \
    ${NON_SIMD} \
"

do_configure_prepend() {
    sed -i 's:/usr/bin/env python:/usr/bin/env python3:' `grep -rl '/usr/bin/env python$' ${S}`
}

FILES_${PN} += "${datadir}/non-sequencer"
