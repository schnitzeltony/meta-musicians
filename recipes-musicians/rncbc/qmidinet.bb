SUMMARY = "JA MIDI Remote Controller via UDP/IP Multicast"
HOMEPAGE = "http://qmidictl.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "8424bf52064019455b27c9a2e0ec4906457752aed8b984061c3bcf5dfa11de80"
PV = "0.9.5"

FILES:${PN} += " \
    ${datadir}/metainfo \
"

RDEPENDS:${PN} += "jack-server"
