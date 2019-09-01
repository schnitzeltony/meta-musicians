SUMMARY = "Yoshimi is a software synthesizer for Linux, a fork of ZynAddSubFX"
HOMEPAGE = "http://yoshimi.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c5f39c482ca5ca058c1ebd39612cf98"

inherit cmake qemu-ext pkgconfig gtk-icon-cache distro_features_check

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

PV = "1.6.0"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/1.6/${BPN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "5e6b1611a3a946360292b30234a910ca"
SRC_URI[sha256sum] = "a0288d528e2394dc1959d7b2a17f9d986bd66b68c78c5a5db87e1c6caf2e8c2d"

OECMAKE_SOURCEPATH = "${S}/src"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
