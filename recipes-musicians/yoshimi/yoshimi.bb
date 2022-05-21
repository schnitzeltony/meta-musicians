SUMMARY = "Yoshimi is a software synthesizer for Linux, a fork of ZynAddSubFX"
HOMEPAGE = "http://yoshimi.sourceforge.net/"
LICENSE = "GPL-2.0-only"
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

PV = "2.2.0"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/2.2/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "bc2a544ff12115f3769237f3732119b660182a9fbdb4416649902a4d97de90e1"

OECMAKE_SOURCEPATH = "${S}/src"

FILES:${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
