SUMMARY = "JACK Audio Connection Kit - Qt GUI Interface"
HOMEPAGE = "http://qjackctl.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qtbase-native \
    qttools-native \
    qtbase \
    jack \
    qtx11extras \
    portaudio-v19 \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache qt5-translation

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/${BPN}/${BPN}/${PV}/${BPN}-${PV}.tar.gz \
    file://QjackCtl.conf \
"
SRCREV = "c88e08a7d62be39ea541d26c8c7e1e7b82289cd3"

SRC_URI[sha256sum] = "39ca2b9d83acfdd16a4c9b3eccd80e1483e1f9a446626f5d00ac297e6f8a166b"
PV = "0.9.6"

FILES:${PN} += " \
    ${datadir}/metainfo \
"

do_install:append() {
    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/QjackCtl.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-defconfig"

FILES:${PN}-defconfig = " \
    ${sysconfdir}/skel/.config/rncbc.org \
"

RDEPENDS:${PN} += " \
    jack-server \
"

RDEPENDS:${PN}-defconfig += " \
    a2jmidid \
    audio-tweaks \
"
