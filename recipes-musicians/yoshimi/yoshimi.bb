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

PV = "1.6.1"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/1.6/${BPN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "e3ae0deddeccd97ac3239e68b38bb0d3"
SRC_URI[sha256sum] = "f22ab90094b93afd34614527ca8f8deabe172d6175188c98fd832cddd8159310"

OECMAKE_SOURCEPATH = "${S}/src"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
