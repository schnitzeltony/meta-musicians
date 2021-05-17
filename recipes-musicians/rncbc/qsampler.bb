SUMMARY = "Qsampler is a LinuxSampler GUI front-end application"
HOMEPAGE = "http://qsampler.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    liblscp \
    libgig \
"

inherit cmake_qt5 gtk-icon-cache qt5-translation mime mime-xdg

SRC_URI = "${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "cd772425ad18a9ee531e64fa7abc8492636fdc7c51f1d78f037a18fdf8008ed5"
PV = "0.9.3"

FILES_${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/mime \
"

#RDEPENDS_${PN} += "jack-server"
