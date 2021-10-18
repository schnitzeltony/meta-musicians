SUMMARY = "An Audio/MIDI multi-track sequencer"
HOMEPAGE = "http://qtractor.sourceforge.net/"
LICENSE = "GPLv2"
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
    git://github.com/rncbc//qtractor.git;branch=midiimportx \
    file://0003-Add-ARM-NEON-acceleration-for-time-stretch-not-yet-t.patch \
    \
    file://Qtractor.conf \
"
SRCREV = "535d58144e474550bf740ff941422ec020581cc9"
PV = "0.9.23+git${SRCPV}"
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
