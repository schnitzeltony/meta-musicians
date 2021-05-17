SUMMARY = "Qt GUI Interface for FluidSynth"
HOMEPAGE = "https://qsynth.sourceforge.io/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    qtx11extras \
    fluidsynth \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "0cd6c09d4f7f02b0b487b4a01caab7965c9ca86c75945cf47659746cc3b75b29"
PV = "0.9.3"

FILES_${PN} += "${datadir}/metainfo"
