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

PV = "21.12"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/21.12/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "dc3ed3db064e754de9fe830b69df40a53dc7157fbfa8a206ca82e5e41c262809"

FILES:${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
"
