SUMMARY = "Matrix Mixer & Trigger (Pre-Processor for Oscilloscope)"
HOMEPAGE = "https://github.com/x42/mixtri.lv2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    libltc \
    jack \
    lv2 \
"

SRC_URI = "gitsm://github.com/x42/mixtri.lv2.git;protocol=https"
SRCREV = "e38bba664839762ce15eb591a0bc7c6b3da2a806"
PV = "0.3.5"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
