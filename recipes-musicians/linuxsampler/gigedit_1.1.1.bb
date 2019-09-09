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
    file://0001-remove-broken-HAS_PANGOMM_CPP11_ENUMS-ifdeffery.patch \
    file://gigedit.png \
    file://gigedit.desktop \
"
SRC_URI[md5sum] = "2597cfddbceb28f5e764929e6c9755ab"
SRC_URI[sha256sum] = "2b77069302f8721fd614ae4e3ca364f1977731deb166bf5af00d389e9908ab21"

EXTRA_OEMAKE = "LIBTOOLFLAGS='--tag=CXX'"

do_install_append() {
    mv ${D}${libdir}/${BPN}/* ${D}${libdir}
    rmdir ${D}${libdir}/${BPN}

    install -d "${D}/${datadir}/pixmaps"
    install ${WORKDIR}/${BPN}.png ${D}/${datadir}/pixmaps/

    install -d  ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/${BPN}.desktop ${D}${datadir}/applications
}

FILES_${PN} += "${libdir}/linuxsampler"
