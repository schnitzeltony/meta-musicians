SUMMARY = "Yoshimi is a software synthesizer for Linux, a fork of ZynAddSubFX"
HOMEPAGE = "http://yoshimi.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c5f39c482ca5ca058c1ebd39612cf98"

inherit cmake pkgconfig gtk-icon-cache features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    alsa-lib \
    fftw \
    jack \
    dssi \
    lv2 \
    cairo \
    fltk fltk-native \
    libmxml \
    libpng jpeg \
    libxrender \
    libxft \
"

PV = "2.1.0"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/2.1/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "b23bc099edadf06c60996392e6001410de5ea9c968a2b370453a61aad9b84e35"

OECMAKE_SOURCEPATH = "${S}/src"

FILES:${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
