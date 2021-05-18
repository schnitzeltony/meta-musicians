SUMMARY = "at1.lv2 is an auto-tuner based on Fons Adriaensen's zita-at1."
HOMEPAGE = "https://x42-plugins.com/x42/x42-autotune"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig features_check

DEPENDS += " \
    virtual/libgl \
    libglu \
    lv2 \
    jack \
    fftw \
"

SRC_URI = "gitsm://github.com/x42/fat1.lv2.git"
SRCREV = "49209f070e94b12c2948be425c58f414369a200f"
PV = "0.6.5"
S = "${WORKDIR}/git"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
