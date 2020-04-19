SUMMARY = "Dynamic Audio Range Compressor"
HOMEPAGE = "https://x42-plugins.com/x42/x42-compressor"
LICENSE = "GPLv3"
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

SRC_URI = "gitsm://github.com/x42/darc.lv2.git"
SRCREV = "4f6b664eba5bacc2c9eda61ac43d4c12cc1021f5"
PV = "0.5.0"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
