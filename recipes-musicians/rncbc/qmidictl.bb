SUMMARY = "A MIDI Network Gateway via UDP/IP Multicast"
HOMEPAGE = "http://qmidinet.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "ee3887a6c197a7c1b927c30f4db0f90c27606e7f6f371df3abb73989d7703010"
PV = "0.9.6"

FILES:${PN} += " \
    ${datadir}/metainfo \
"
