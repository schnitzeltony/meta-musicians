SUMMARY = "A MIDI Network Gateway via UDP/IP Multicast"
HOMEPAGE = "http://qmidinet.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "3b776f55136a5d69f5dc42510ae4583898b87b4f3c6c14b276b2c4257ba39bfc"
PV = "0.9.5"

FILES:${PN} += " \
    ${datadir}/metainfo \
"
