SUMMARY = "An instrument editor for gig files"
HOMEPAGE = "http://www.linuxsampler.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=751419260aa954499f7abaabaa882bbe \
"

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    libxslt-native \
    gtkmm3 \
    linuxsampler \
"

inherit autotools pkgconfig gtk-icon-cache

SRC_URI = " \
    http://download.linuxsampler.org/packages/${BPN}-${PV}.tar.bz2 \
    file://gigedit.png \
    file://gigedit.desktop \
"
SRC_URI[md5sum] = "1ca041c960d997dd8a58c4072056f165"
SRC_URI[sha256sum] = "d18abe98d8bc6ec0d1ac8b8b185a25d7e2454225fcb030f80e19099c4262f720"

EXTRA_OEMAKE = "LIBTOOLFLAGS='--tag=CXX'"

do_install_append() {
    install -d "${D}/${datadir}/pixmaps/${BPN}"
    install ${WORKDIR}/${BPN}.png ${D}/${datadir}/pixmaps/${BPN}/

    install -d  ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/${BPN}.desktop ${D}${datadir}/applications
}

FILES_SOLIBSDEV = "${libdir}/${BPN}/lib*${SOLIBSDEV}"

FILES_${PN} += "${libdir}/linuxsampler"
