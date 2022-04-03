SUMMARY = "Qsampler is a LinuxSampler GUI front-end application"
HOMEPAGE = "http://qsampler.sourceforge.net"
LICENSE = "GPL-2.0-only"
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
SRC_URI[sha256sum] = "33a37c5528d73a4ab83ded5c16aefe301807510b1f233c6b360a828482679d20"
PV = "0.9.6"

FILES:${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/mime \
"

#RDEPENDS:${PN} += "jack-server"
