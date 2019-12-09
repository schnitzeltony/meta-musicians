SUMMARY = "aubio is designed for the extraction of annotations from audio signals"
HOMEPAGE = "https://aubio.org/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf pkgconfig

DEPENDS += " \
    jack \
    ffmpeg \
    libsndfile1 \
    libsamplerate0 \
    python3-numpy \
"

SRC_URI = " \
    https://aubio.org/pub/${BPN}-${PV}.tar.bz2 \
    file://0001-do-not-build-tests.patch \
    file://0002-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[md5sum] = "50c9c63b15a2692378af5d602892f16a"
SRC_URI[sha256sum] = "d48282ae4dab83b3dc94c16cf011bcb63835c1c02b515490e1883049c3d1f3da"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --sysconfdir=${sysconfdir} \
    --libdir=${libdir} \
"
