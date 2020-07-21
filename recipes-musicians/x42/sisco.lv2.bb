SUMMARY = "Simple Scope"
HOMEPAGE = "http://x42.github.io/sisco.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    lv2 \
    jack \
"

SRC_URI = "gitsm://github.com/x42/sisco.lv2.git"
SRCREV = "ce8139f989a182f4968911494a1c72940f9f53ee"
PV = "0.9.0"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
