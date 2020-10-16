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
    --bindir=${bindir} \
    --libdir=${libdir} \
"

python waf_preconfigure() {
}

do_configure_prepend() {
    for pfile in `grep -rl '/usr/bin/env python$' ${S}`; do
        sed -i 's:/usr/bin/env python:/usr/bin/env python3:' $pfile
    done
}

FILES_${PN} += "${datadir}/non-sequencer"

PACKAGES =+ "${PN}-session-manager"
FILES_${PN}-session-manager = " \
    ${datadir}/applications/non-session-manager.desktop \
    ${datadir}/icons/hicolor/*/apps/non-session-manager.png \
    ${datadir}/pixmaps/non-session-manager \
    ${bindir}/jackpatch \
    ${bindir}/non-session-manager \
    ${bindir}/nsm-proxy \
    ${bindir}/nsm-proxy-gui \
    ${bindir}/nsmd \
"

RCONFLICTS_${PN}-session-manager = "new-session-manager"
RREPLACES_${PN}-session-manager = "new-session-manager"
