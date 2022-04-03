SUMMARY = "JA MIDI Remote Controller via UDP/IP Multicast"
HOMEPAGE = "http://qmidictl.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "f72bcb2d78e481bd707a7675819eed926c953ba2c01f8265c994d2849cb31603"
PV = "0.9.6"

FILES:${PN} += " \
    ${datadir}/metainfo \
"

RDEPENDS:${PN} += "jack-server"
