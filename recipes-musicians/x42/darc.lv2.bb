SUMMARY = "Dynamic Audio Range Compressor"
HOMEPAGE = "https://x42-plugins.com/x42/x42-compressor"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=9eef91148a9b14ec7f9df333daebc746"

inherit pkgconfig

DEPENDS += " \
    libglu \
    cairo \
    pango \
    lv2 \
    jack \
    liblo \
"

SRC_URI = "gitsm://github.com/x42/darc.lv2.git;branch=master;protocol=https"
SRCREV = "c367b6be8c1a91279085064ccf1648d97963c240"
PV = "0.6.0"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
