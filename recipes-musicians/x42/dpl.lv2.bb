SUMMARY = "Digital Peak Limiter LV2 Plugin"
HOMEPAGE = "https://x42-plugins.com/x42/x42-limiter"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=9eef91148a9b14ec7f9df333daebc746"

inherit pkgconfig

DEPENDS += " \
    libglu \
    cairo \
    pango \
    lv2 \
    jack \
"

SRC_URI = "gitsm://github.com/x42/dpl.lv2.git;branch=master;protocol=https"
SRCREV = "e478ef7a1f9b41bc4acd7eec4fc2017022aeed2e"
PV = "0.5.2"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
