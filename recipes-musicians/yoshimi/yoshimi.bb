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

PV = "1.7.3"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/1.7/${BPN}-${PV}.tar.bz2"
SRC_URI[sha256sum] = "9cb9537f15962ac2acbc0612c5aa631010c40680e31ba9a4a3a23e57f114abc7"

OECMAKE_SOURCEPATH = "${S}/src"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
