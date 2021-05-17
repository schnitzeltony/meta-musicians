SUMMARY = "JACK Audio Connection Kit - Qt GUI Interface"
HOMEPAGE = "http://qjackctl.sourceforge.net"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
    qtx11extras \
    portaudio-v19 \
"

inherit cmake_qt5 gtk-icon-cache qt5-translation

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://QjackCtl.conf \
"
SRCREV = "c88e08a7d62be39ea541d26c8c7e1e7b82289cd3"

SRC_URI[sha256sum] = "e9c2ffc219863c8c3dcdb05c4870d419b1625906852294f15c62d590b331bd18"
PV = "0.9.3"

FILES_${PN} += " \
    ${datadir}/metainfo \
"

do_install_append() {
    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/QjackCtl.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-defconfig"

FILES_${PN}-defconfig = " \
    ${sysconfdir}/skel/.config/rncbc.org \
"

RDEPENDS_${PN} += " \
    jack-server \
"

RDEPENDS_${PN}-defconfig += " \
    a2jmidid \
    audio-tweaks \
"
