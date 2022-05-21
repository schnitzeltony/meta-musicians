SUMMARY = "Digital Peak Limiter LV2 Plugin"
HOMEPAGE = "https://x42-plugins.com/x42/x42-limiter"
LICENSE = "GPL-3.0-only"
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
SRCREV = "f12b3f88b8087417e697ba6722ddc2a0eb8569e9"
PV = "0.5.4"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
