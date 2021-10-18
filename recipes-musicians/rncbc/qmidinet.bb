SUMMARY = "JA MIDI Remote Controller via UDP/IP Multicast"
HOMEPAGE = "http://qmidictl.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "ed48b89148188293d501a68836b77a5866686289f952e1eccc655a1da7dbfe9d"
PV = "0.9.4"

FILES:${PN} += " \
    ${datadir}/metainfo \
"

RDEPENDS:${PN} += "jack-server"
