SUMMARY = "Rosegarden is a music composition and editing environment"
HOMEPAGE = "http://www.rosegardenmusic.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b33ec9f109e9943af917779ba6ec522e"

DEPENDS += " \
    qttools-native \
    qtbase \
    qtx11extras \
    virtual/libx11 \
    jack \
    dssi \
    zlib \
    lrdf \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache features_check mime mime-xdg

REQUIRED_DISTRO_FEATURES = "x11"

PV = "20.12"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "886684afc5858a9578234d1f845188db130114f7fbf38208c4d5ecda15131c5b"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
"
