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

REQUIRED_DISTRO_FEATURE = "x11"

PV = "20.06"
SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-with-Qt-5.15.patch \
"
SRC_URI[md5sum] = "16f0cbbb3104c9f58f644b18e4cbaf19"
SRC_URI[sha256sum] = "d94c0eb0e28c51662d9056c7e50e5b394a8648442a17dacf99b9718e674e3dc5"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
"
