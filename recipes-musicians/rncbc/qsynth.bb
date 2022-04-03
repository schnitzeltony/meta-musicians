SUMMARY = "Qt GUI Interface for FluidSynth"
HOMEPAGE = "https://qsynth.sourceforge.io/"
LICENSE = "GPL-2.0-only"
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
SRC_URI[sha256sum] = "0e0d78c26cdd924c774359f306692a9a59f107ebab8b41aa6803b15479207030"
PV = "0.9.7"

FILES:${PN} += "${datadir}/metainfo"
