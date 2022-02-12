SUMMARY = "Qt GUI Interface for FluidSynth"
HOMEPAGE = "https://qsynth.sourceforge.io/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

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
SRC_URI[sha256sum] = "431843099594cc2e861392133ec77011a9d82214c64d5214593935acfbe77f26"
PV = "0.9.6"

FILES:${PN} += "${datadir}/metainfo"
