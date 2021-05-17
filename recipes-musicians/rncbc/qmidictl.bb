SUMMARY = "A MIDI Network Gateway via UDP/IP Multicast"
HOMEPAGE = "http://qmidinet.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
"

inherit cmake_qt5 gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "44d99946474e5609bb3dc8444966591d0193cfa3bf5b78b05de0dd277ef30b49"
PV = "0.9.3"

FILES_${PN} += " \
    ${datadir}/metainfo \
"
