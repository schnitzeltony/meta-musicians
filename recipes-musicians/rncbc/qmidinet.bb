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

inherit cmake_qt5 gtk-icon-cache

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "3412f7da2642a2a1afc3432b770c496eb320e787bbb550aebc7f368c90f2e15f"
PV = "0.9.3"

FILES_${PN} += " \
    ${datadir}/metainfo \
"

RDEPENDS_${PN} += "jack-server"
