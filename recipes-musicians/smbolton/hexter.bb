SUMMARY = "Yamaha DX7 modeling DSSI plugin"
HOMEPAGE = "http://dssi.sourceforge.net/hexter.html"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit autotools pkgconfig gtk-icon-cache

DEPENDS += " \
    gtk+ \
    dssi \
    liblo \
    ladspa-sdk \
"

SRC_URI = " \
    git://github.com/smbolton/hexter.git;branch=master;protocol=https \
    file://hexter.desktop \
    file://hexter.png \
"
SRCREV = "1cf1bfea5962f7c9726e0cf809b762b3b2655225"
PV = "1.1.1"
S = "${WORKDIR}/git"

do_compile:append() {
    cd ${S}/extra
    $CC $CFLAGS -o tx_edit tx_edit.c -lcurses -lasound -lm ${LDFLAGS}
}

do_install:append() {
    install -d ${D}/${datadir}/applications
    install -m 644 ${WORKDIR}/hexter.desktop ${D}/${datadir}/applications/

    install -d ${D}/${datadir}//icons/hicolor/36x36/apps
    install -m 644 ${WORKDIR}/hexter.png ${D}/${datadir}/icons/hicolor/36x36/apps/

    install -d ${D}/${bindir}
    ln -s jack-dssi-host ${D}/${bindir}/hexter

    install -m 755 ${S}/extra/tx_edit ${D}/${bindir}
}

FILES:${PN} += " \
    ${libdir}/dssi \
"

# standalone needs jack-dssi-host
RDEPENDS:${PN} += "dssi"
