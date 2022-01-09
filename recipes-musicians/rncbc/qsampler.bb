SUMMARY = "Qsampler is a LinuxSampler GUI front-end application"
HOMEPAGE = "http://qsampler.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    liblscp \
    libgig \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache qt5-translation mime mime-xdg

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "973d6eac32a12513f3e42d1c5760e043eb344b762abbc02923b6391daa7175a9"
PV = "0.9.5"

FILES:${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/mime \
"

#RDEPENDS:${PN} += "jack-server"
