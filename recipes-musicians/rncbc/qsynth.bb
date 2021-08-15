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
SRC_URI[sha256sum] = "76580890c75eeeebf852530a10f86d67b31f49305ced1bc7b3e436ca4f86fc93"
PV = "0.9.4"

FILES:${PN} += "${datadir}/metainfo"
