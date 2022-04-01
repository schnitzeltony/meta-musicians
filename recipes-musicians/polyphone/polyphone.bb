SUMMARY = "Soundfont editor"
HOMEPAGE = "http://polyphone-soundfonts.com/en/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=6;endline=18;md5=11e8b245e7c8a15dafd52bc856ef3ff1"

inherit qmake5 pkgconfig gtk-icon-cache mime mime-xdg dos2unix

DEPENDS += " \
    qttools-native \
    qtbase \
    qtsvg \
    alsa-lib \
    jack \
    portaudio-v19 \
    rtmidi \
    qcustomplot \
    stk \
    libvorbis \
    libogg \
"

SRC_URI = " \
    git://github.com/davy7125/polyphone.git;protocol=https;branch=master \
    file://polyphone.desktop \
    file://polyphone.mime \
"
SRCREV = "5b666133f718c3fe25264796394effac3bf0679f"
PV = "2.3.0"
S = "${WORKDIR}/git/sources"

do_configure:prepend() {
    sed -i \
        -e 's:= /usr/include:= ${STAGING_INCDIR}:g' \
        ${S}/polyphone.pro
}

CXXFLAGS += "-I${STAGING_INCDIR}/qcustomplot"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/bin/polyphone ${D}${bindir}/

    install -d ${D}${datadir}/pixmaps
    install -m 0644 ${S}/resources/polyphone.png ${D}${datadir}/pixmaps/

    install -d ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/${BPN}.desktop ${D}${datadir}/applications/

    install -d ${D}${datadir}/mime/packages
	install -m 0644 ${WORKDIR}/${BPN}.mime ${D}${datadir}/mime/packages/${BPN}.xml
}

FILES:${PN} += " \
    ${datadir}/mime \
"

