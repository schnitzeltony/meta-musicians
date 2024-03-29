SUMMARY = "Matrix Mixer & Trigger (Pre-Processor for Oscilloscope)"
HOMEPAGE = "https://github.com/x42/mixtri.lv2"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    libltc \
    jack \
    lv2 \
"

SRC_URI = "gitsm://github.com/x42/mixtri.lv2.git;branch=master;protocol=https"
SRCREV = "fb6cb731d4c8e56503a16316334b6997e1751f5b"
PV = "0.4.5"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES:${PN} += "${libdir}/lv2"
