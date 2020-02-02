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

PV = "1.7.0"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/1.7/${BPN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "fa23c98bb7493a85eef8cc680d979e22"
SRC_URI[sha256sum] = "5176e2b8013f92d25dc6331c2f81563174ea350a42b747905f93e93b0edba738"

OECMAKE_SOURCEPATH = "${S}/src"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${libdir}/lv2 \
"
