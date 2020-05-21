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

PV = "1.7.1"
SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/1.7/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-compatibility-with-lv2-1.18.patch \
"
SRC_URI[md5sum] = "fb1010d11c506a9f908729a7b5be4774"
SRC_URI[sha256sum] = "47f134165e24cd503f1d09cfec6d7e84dd22d347b0967992d05467e98be67381"

OECMAKE_SOURCEPATH = "${S}/src"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
