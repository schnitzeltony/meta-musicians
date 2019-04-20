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

inherit cmake_qt5 pkgconfig gtk-icon-cache distro_features_check mime

REQUIRED_DISTRO_FEATURE = "x11"

PV = "18.12"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "210343885fd710096ab26903672fea6c"
SRC_URI[sha256sum] = "6b2331ae988f20904807b4f2c687048c03fd8b0c117705d5d37cd8b941752996"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
"
