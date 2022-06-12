SUMMARY = "Musical Instrument Tuner"
HOMEPAGE = "http://x42-plugins.com/x42/x42-tuner"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    glib-2.0 \
    pango \
    cairo \
    lv2 \
    jack \
    fftw \
"

SRC_URI = "gitsm://github.com/x42/tuna.lv2.git;branch=master;protocol=https"
SRCREV = "ed96d5dad9ea2e60d226fd4f68c7ab8e938c78b2"
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
