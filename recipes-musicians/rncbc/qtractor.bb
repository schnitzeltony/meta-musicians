SUMMARY = "An Audio/MIDI multi-track sequencer"
HOMEPAGE = "http://qtractor.sourceforge.net/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS += " \
    qttools-native \
    qtbase \
    qtx11extras \
    jack \
    lilv \
    libmad \
    rubberband \
    dssi \
    suil \
    aubio \
"

inherit cmake_qt5 pkgconfig gtk-icon-cache mime mime-xdg qt5-translation

SRC_URI = " \
    git://github.com/rncbc//qtractor.git;branch=midiimportx;protocol=https \
    file://0003-Add-ARM-NEON-acceleration-for-time-stretch-not-yet-t.patch \
    \
    file://Qtractor.conf \
"
SRCREV = "7408216eaee4eb1878f92a95ac8dd2bb405fb38b"
PV = "0.9.24+git${SRCPV}"
S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}/${sysconfdir}/skel/.config/rncbc.org
    install -m 0644 ${WORKDIR}/Qtractor.conf ${D}/${sysconfdir}/skel/.config/rncbc.org/
}

PACKAGES =+ "${PN}-defconfig"

FILES:${PN} += " \
    ${datadir}/mime \
    ${datadir}/metainfo \
"

FILES:${PN}-defconfig = " \
    ${sysconfdir}/skel/.config/rncbc.org \
"

RDEPENDS:${PN}-defconfig = "${PN} fluidsynth-dssi"
